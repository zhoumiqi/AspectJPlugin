package com.aop.aspectj;

import android.app.Activity;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.reactivex.functions.Consumer;

@Aspect
public class PermissionAspect {

    @Around("execution(@com.aop.aspectj.Permission * *(..)) && @annotation(permission)")
    public void aroundJoinPoint(final ProceedingJoinPoint joinPoint, Permission permission) throws Throwable {
//        获取栈顶Activity(上下文)
        final Activity activity = BaseApp.getApp().getCurActivity();
        String[] permissions = permission.value();
        //申请permissions权限
        new RxPermissions(activity).request(permissions)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if (granted) {
                            try {
                                //如果通过则joinPoint.proceed();调用原方法
                                joinPoint.proceed();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        } else {
                            Toast.makeText(activity, "获取权限失败", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        //拿到方法签名进而拿到参数内容
//        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
//        Permission per=signature.getMethod().getAnnotation(Permission.class);
//        String[] param=per.value();
//        System.out.println(String.format("%s 参数,时间：%d ms",param,time));

    }
}


