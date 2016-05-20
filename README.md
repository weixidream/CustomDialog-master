# CustomDialog-master
========= 
###一个简单的自定义Dialog

###包括dialog内view的设置

###用法如下
> 
DialogBuilder.getInstance(MainActivity.this)//获取dialog单例
> 
                        .withTitle("Dialog /Title")//设置标题
> 
                        .withContent("Dialog /Content")//设置内容
> 
                        .withConfirmText("Button OK")//设置确定按钮文本
> 
                        .setConfirmClickListener(new DialogBuilder.OnClickListener() {//设置点击事件
> 
                            @Override
> 
                            public void onClick(DialogBuilder dialogBuilder) 
> 
                                Toast.makeText(MainActivity.this, "Dialog Ok Button", Toast.LENGTH_SHORT).show();
>  
                            }
> 
                        })
> 
                        .show();

Gradle 配置如下
------- 
> 
dependencies {
> 
    compile 'com.liuhc.library.dialog:DialogLibrary:1.0.2'
> 
}
> 
