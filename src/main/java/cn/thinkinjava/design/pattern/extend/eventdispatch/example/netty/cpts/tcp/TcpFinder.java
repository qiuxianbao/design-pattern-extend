package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp;


import cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter.ParamNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qiuxianbao
 * @date 2024/01/08
 */
public interface TcpFinder {
    public static final byte NODE_TYPE_PATH=0;
    public static final byte NODE_TYPE_ENTITY=1;

    public interface Node{
        byte getNodeType();
    }

    public class EntityNode implements Node{

        protected Method method;
        protected ParamNode[] params;

        private Object resource;

        public EntityNode(Method method,ParamNode[] params,Object resource){
            this.resource =resource;
            this.method = method;
            this.params = params;
        }

        public void onService(TcpRequest request, TcpResponse response)throws Throwable{

            // TODO-QIU: 2024年1月8日, 0008
//            if(resource instanceof TcpBefore){
//                ((TcpBefore)resource).onBefore(request, response);
//            }

            Object []args=assembleParams(params,request,response);
            Object result =  callMethod(args);
            // TODO-QIU: 2024年1月8日, 0008
//            if(resource instanceof TcpAfter){
//                ((TcpAfter)resource).onAfter(request, response,result);
//            }
//            else{
//                After(request, response,result);
//            }

        }

        private Object callMethod(Object []args)throws Throwable{
            try{
                return method.invoke(resource, args);
            }catch(InvocationTargetException e){
                throw e.getTargetException();
            }

        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof EntityNode){
                return true;
            }
            return false;
        }

        @Override
        public byte getNodeType(){
            return NODE_TYPE_ENTITY;
        }

        @Override
        public int hashCode(){
            return 1;
        }

//        @SuppressWarnings("rawtypes")
//        public void After(TcpRequest request, TcpResponse response, ResponseResult<?> result) throws Exception{
//            if(result!=null && result instanceof ResponseResult){
//                response.setResult(JSONObject.toJSONString(result));
//                return;
//            }
//            StringBuilder builder=new StringBuilder();
//            if(result != null){
//                builder.append("{\"state\":").append(result.getState());
//                builder.append(",\"desc\":\"").append(result.getDesc()).append('\"');
//                if (result.getValue() instanceof String) {
//                    builder.append(",\"value\":\"").append(result.getValue()).append('\"');
//                }
//                else if(result.getValue() instanceof Collection){
//                    boolean once=false;
////					builder.append(",\"value\":[");
//                    for(Object t : (Collection)result.getValue()){
//                        if(once){
//                            builder.append(',');
//                        }
//                        else{
//                            once=true;
//                        }
//                        if (t instanceof String) {
//                            builder.append(",\"value\":\"").append(t).append('\"');
//                        }
//                        else{
//                            builder.append(t);
//                        }
//                    }
//                    builder.append(']');
//                }
//                else {
//                    builder.append(",\"value\":").append(result.getValue());
//                }
//                builder.append('}');
//            }
//
//            response.setResult(builder.toString());
//        }

        protected Object[] assembleParams(ParamNode[] params, TcpRequest request,TcpResponse response)throws Exception{
            Object args[]=new Object[params.length];

            // TODO-QIU: 2024年1月8日, 0008
//            Map<String,String> paramMap=request.getParams();
//
//            for(int i=0;i<params.length;i++){
//                ParamNode n=params[i];
//                if(n.getParamType().isAssignableFrom(TcpRequest.class)){
//                    args[i]=request;
//                }
//                else if(n.getParamType().isAssignableFrom(TcpResponse.class)){
//                    args[i]=response;
//                }
//                else{
//                    Object v=paramMap.get(n.getParamName());
//                    if(n.isRequired()&&v==null){
//                        throw new ExtException(ErrorState.MissParameter);
//                    }
//                    //convert
//                    try{
//                        ParamConverter<?> cvt=n.getConvert();
//                        if(cvt!=null){
//                            args[i]=cvt.convert((String)v);
//                        }
//                        else{
//                            args[i]=v;
//                        }
//
//                    }catch(Exception e){
//                        throw new ExtException(ErrorState.ParamTypeError);
//                    }
//                }
//            }
            return args;
        }

    }

    EntityNode lookup(TcpRequest request)throws Exception;

    void addMethod(String method, EntityNode entity) throws IllegalArgumentException;


}
