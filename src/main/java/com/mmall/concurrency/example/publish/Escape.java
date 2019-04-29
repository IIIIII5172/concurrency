package com.mmall.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;


/**?
 * @author IIIIII
 * @create 2019-01-07-22:24
 * @package com.mmall.concurrency.example.publish
 **/
@Slf4j
public class Escape {
    private int thisCanBeEscape=0;
    public Escape(){

    }
    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
