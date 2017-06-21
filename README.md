# AspectJPlugin is a gradle plugin for aop
使用方法：

1、在项目的build.gradle中添加classpath

buildscript {

     ……
     
      dependencies {
      
          ……
          
          //自定义aspectj插件
          
          classpath 'com.zmq.plugin:aspectj:1.0.0'
          
      }
      
  }

2、在所有需要用到插件相关类的Module中都引入插件

比如在demo中app以及aop两个module都必须引入插件

//添加支持AspectJ插件

apply plugin: 'com.zmq.plugin.aspectj'

注意：使用自定义插件aspectj时，暂时不能在library中使用lambda表达式(可能AS更新会支持)，

否则会在安装APK时生成一堆ajcore.XXX.XXX.XXX.txt的文件，

Gradle Console会输出报错信息，AOP切片使用也会报错，提示

No static method of aspectOf()……
