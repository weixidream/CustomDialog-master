# CustomDialog-master
一个简单的自定义Dialog
包括dialog内view的设置

#用法如下
DialogBuilder.getInstance(MainActivity.this)

                        .withTitle("Dialog /Title")

                        .withContent("Dialog /Content")

                        .withConfirmText("Button OK")

                        .setConfirmClickListener(new DialogBuilder.OnClickListener() {

                            @Override

                            public void onClick(DialogBuilder dialogBuilder) {

                                Toast.makeText(MainActivity.this, "Dialog Ok Button", Toast.LENGTH_SHORT).show();
                         
                            }

                        })
                        .show();

#Gradle 配置如下
dependencies {

    compile 'com.liuhc.library.dialog:DialogLibrary:1.0.2'

}
