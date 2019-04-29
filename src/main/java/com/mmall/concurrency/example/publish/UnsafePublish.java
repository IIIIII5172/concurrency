package com.mmall.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**?
 * @author IIIIII
 * @create 2019-01-07-22:17
 * @package com.mmall.concurrency.example.publish
 **/
@Slf4j
public class UnsafePublish {
    //new出类的实例之后所有线程都可以访问并修改变量
    private String[] states={"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish=new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
