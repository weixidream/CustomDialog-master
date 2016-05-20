# CustomDialog-master
========= 
一个简单的自定义Dialog
------- 
包括dialog内view的设置

用法如下
DialogBuilder.getInstance(MainActivity.this)\<br> 
                        .withTitle("Dialog /Title")\<br> 
                        .withContent("Dialog /Content")\<br> 
                        .withConfirmText("Button OK")\<br> 
                        .setConfirmClickListener(new DialogBuilder.OnClickListener() {\<br> 
                            @Override\<br> 
                            public void onClick(DialogBuilder dialogBuilder) {\<br> 
                                Toast.makeText(MainActivity.this, "Dialog Ok Button", Toast.LENGTH_SHORT).show();\<br> 
                            }\<br> 
                        })\<br> 
                        .show();\<br> 

Gradle 配置如下\<br> 
------- 
dependencies {\<br> 
    compile 'com.liuhc.library.dialog:DialogLibrary:1.0.2'\<br> 
}\<br> 
