# 项目基础
本项目立意：尽量简单的复制粘贴使用，所以应该拒绝多级调用过度封装。

1. 配置 build_config.gradle

    常用库:
    gson，glide，okhttp，easypermissions
    
    com.github.CymChad:BaseRecyclerViewAdapterHelper     :  recyclerview 的动画、adapter、复杂布局 库
    com.amitshekhar.android:debug-db                     :  可以在浏览器中查看到当前使用数据库信息，存储的SP信息。
    
2. BaseActivity 
    
3. util 包，基础工具包。

4. 

5. example 样例代码 

   AppListActivity             : 列出手机中第三方应用 
   AutoImageViewActivity       : ImageView 的动画移动，可以用于移动背景
   DialogActivity              : 一些常用的Dialog和DialogLoading
   JetpackActivity             : databinding 的使用；lifecycle的使用；
   LoginActivity               : 标准登录界面
   NestedScrollViewActivity    : 滑动嵌套的使用
   PermissionActivity          : EasyPermissions的使用，4个敏感权限的申请（sd卡，相机，电话，定位）
   RecyclerViewActivity        : adapter的使用；swipeRefreshLayout下拉刷新的使用；（）缺失--------上拉加载更多，item点击，
   SplashActivity              : 闪屏，版本号，动画展示；
   ToastActivity               : 一些自定义Toast展示；
   ViewAnimationActivity       : 一些view的小动画；

   
   网络请求
   动画 
   UI
   
   
   感谢下列网站，组织或个人。
### 阿里巴巴矢量图库 www.iconfont.cn
### https://github.com/Tamsiree/RxTool