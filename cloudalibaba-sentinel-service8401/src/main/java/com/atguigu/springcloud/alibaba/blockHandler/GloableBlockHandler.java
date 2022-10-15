package com.atguigu.springcloud.alibaba.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class GloableBlockHandler {

    public static CommonResult<String> limit1Handler(String p1,BlockException e)
    {
        return new CommonResult<String>(500,"this is limit1Handler 哭哭哭 11111");
    }


    public static CommonResult<String> limit2Handler(BlockException e)
    {
        return new CommonResult<String>(500,"this is limit2Handler 哭哭哭 22222");
    }

}
