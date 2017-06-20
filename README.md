# AspectJPlugin is a gradle plugin for aop
使用方法：
1、在项目的build.gradle中添加classpath

buildscript {

     ……
     
      dependencies {
      
          ……
          
          //自定义aspectj插件
          
          classpath 'com.plugin.aop:aspectj:1.0.0'
          
      }
      
  }

2、在所有需要用到插件相关类的Module中都引入插件

比如在demo中app以及aop两个module都必须引入插件

//添加支持AspectJ插件

apply plugin: 'com.plugin.aop.aspectj'

