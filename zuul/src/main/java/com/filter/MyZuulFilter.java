package com.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Demo_Null
 * @date 2020/11/9
 * @description 自定义过滤器
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    /**
     * 什么时候开始过滤
     * @author Demo_Null
     * @date 2020/11/9
     * @param
     * @return java.lang.String
     **/
    @Override
    public String filterType() {
        // pre：可以在请求被路由之前调用
        // route：在路由请求时候被调用
        // error：处理请求时发生错误时被调用
        // post：在 route 和 error 过滤器之后被调用
        return "pre";
    }

    /**
     * 过滤器优先级
     * @author Demo_Null
     * @date 2020/11/9
     * @param
     * @return int
     **/
    @Override
    public int filterOrder() {
        // 返回的数值越小优先级越高
        return 0;
    }

    /**
     * 是否开启该过滤器
     * @author Demo_Null
     * @date 2020/11/9
     * @param
     * @return boolean
     **/
    @Override
    public boolean shouldFilter() {
        // 返回 false 表示不启用
        return false;
    }

    /**
     * 过滤器具体逻辑
     * @author Demo_Null
     * @date 2020/11/9
     * @param
     * @return java.lang.Object
     **/
    @Override
    public Object run() throws ZuulException {
        // 过滤器内 return Object 都表示继续执行
        // RequestContext.getCurrentContext().sendZuulResponse(false) 这个请求最终不会被 zuul 转发到后端服务器
        // 但是如果当前 Filter 后面还存在其他 Filter,那么其他 Filter 仍然会被调用到
        return null;
    }
}
