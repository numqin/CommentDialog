# CommentDialog
![](http://i.imgur.com/LItfGGH.gif)
## 开始

### 自定义Dialog
首先是自定义一个评论的带 EditText 的 dailog (这个可以看我前面的文章[http://qinlei.space/2017/03/31/%E8%87%AA%E5%AE%9A%E4%B9%89-dialog/](http://qinlei.space/2017/03/31/%E8%87%AA%E5%AE%9A%E4%B9%89-dialog/))

### 处理 Dialog 中 Edittext 键盘不弹出
键盘无法弹出处理, 这是因为系统给 Dialog 设置了 WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM 
这个参数会让Dialog遮挡住软键盘，显示在软键盘的前面。
```
//使得点击 Dialog 中的EditText 可以弹出键盘
getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
```
```
//总是显示键盘
getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
```


### 处理软键盘显示时,点击返回键关闭 dialog 和软键盘
系统在处理返回键时, 如果显示了软键盘, 则会先处理软键盘的隐藏
这里我们自定义 EditText 来处里软键盘显示时的返回键的事件监听  

自定义 EditText 重写 dispatchKeyEventPreIme() 事件
```
    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (callBack != null) {
                callBack.callBack();
            }
            return true;
        }
        return super.dispatchKeyEventPreIme(event);
    }
```
