# SimplePopo
根据view任意显示位置的popoWindows


使用方法：
```
//在project的build.gradle中设置
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 //在module的build.gradle中设置
 dependencies {
	        implementation 'com.github.rineone:SimplePopo:v1.0'
	}
```
基本用法
```java
 SimplePopupWindow popupWindow = SimplePopupWindow.Builder
                .build( this, mContentView)      //此处mContentView为显示dialog View
                .setAlpha(0.6f)                   //默认全透明    背景灰度
                .setOutsideTouchDismiss(true)    //默认true  点击外部消失
                .createPopupWindow();
        popupWindow.showAtAnchorView(tvView   //此处tvView为显示dialog根本此tvView来进行显示的位置
        , VerticalPosition.CENTER, HorizontalPosition.CENTER);
```
****
效果图
![Alt text](/app/src/main/res/drawable/ces.jpg)

