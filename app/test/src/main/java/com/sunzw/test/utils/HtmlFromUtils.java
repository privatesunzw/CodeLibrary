package com.sunzw.test.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;

import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class HtmlFromUtils {

    private static Drawable getImageFromNetwork(String imageUrl) {
        URL myFileUrl = null;
        Drawable drawable = null;
        try {
            myFileUrl = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            drawable = Drawable.createFromStream(is, null);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return drawable;
    }

    private static Drawable drawable;


    public static void setTextFromHtml(final Activity context, final TextView v, final String sources) {
        if (TextUtils.isEmpty(sources) || context == null || v == null)
        {return;}
        synchronized (HtmlFromUtils.class) {//同步锁
            v.setMovementMethod(LinkMovementMethod.getInstance());
            v.setText(Html.fromHtml(sources));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Html.ImageGetter imageGetter = new Html.ImageGetter() {


                        @Override
                        public Drawable getDrawable(String source) {
                            source = "" + source;
                            drawable = getImageFromNetwork(source);
                            if (drawable != null) {

                                int w = drawable.getIntrinsicWidth();
                                int h = drawable.getIntrinsicHeight();

                                if (w < h && h > 0) {
                                    float scale = (400.0f / h);
                                    w = (int) (scale * w);
                                    h = (int) (scale * h);
                                } else if (w > h && w > 0) {
                                    float scale = (1000.0f / w);
                                    w = (int) (scale * w);
                                    h = (int) (scale * h);
                                }

                                drawable.setBounds(0, 0, w, h);
                            } else if (drawable == null) {
                                //bindData();
                                return null;
                            }
                            return drawable;
                        }
                    };

                    final CharSequence charSequence = Html.fromHtml(sources, imageGetter, new URLTagHandler(context));
                    //在activiy的runOnUiThread方法中更新ui
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            v.setText(charSequence);
                        }
                    });


                }
            }).start();
        }

    }



    private static class URLTagHandler implements Html.TagHandler {

        private Context mContext;

        public URLTagHandler(Context context) {
            mContext = context.getApplicationContext();
        }

        @Override
        public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
            // 处理标签<img>
            if (tag.toLowerCase(Locale.getDefault()).equals("img")) {
                // 获取长度
                int len = output.length();
                // 获取图片地址
                ImageSpan[] images = output.getSpans(len - 1, len, ImageSpan.class);
                String imgURL = images[0].getSource();
                // 使图片可点击并监听点击事件
                output.setSpan(new URLTagHandler.ClickableImage(mContext, imgURL), len - 1, len, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        private class ClickableImage extends ClickableSpan {
            private String url;
            private Context context;

            public ClickableImage(Context context, String url) {
                this.context = context;
                this.url = url;
            }

            @Override
            public void onClick(View widget) {
                // 进行图片点击之后的处理
                // Toast.makeText(context, "点击图片的地址" + url, Toast.LENGTH_LONG).show();
            }
        }
    }
}
