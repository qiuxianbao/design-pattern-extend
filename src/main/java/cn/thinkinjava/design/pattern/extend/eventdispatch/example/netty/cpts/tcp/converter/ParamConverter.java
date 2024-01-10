package cn.thinkinjava.design.pattern.extend.eventdispatch.example.netty.cpts.tcp.converter;


public interface ParamConverter<T> {
	
	T convert(String source)throws Exception;
	
	public class String2IntegerConverter implements ParamConverter<Integer> {
		@Override
		public Integer convert(String source)throws Exception{
			if(source!=null&&source.length()>0){
				return Integer.parseInt(source);
			}
			return null;
		}
	}

	public class String2LongConverter implements ParamConverter<Long> {
		@Override
		public Long convert(String source)throws Exception{
			if(source!=null&&source.length()>0){
				return Long.parseLong(source);
			}
			return null;
		}
	}

	public class String2DoubleConverter implements ParamConverter<Double> {
		@Override
		public Double convert(String source)throws Exception{
			if(source!=null&&source.length()>0){
				return Double.parseDouble(source);
			}
			return null;
		}
	}

	public class String2ShortConverter implements ParamConverter<Short> {
		@Override
		public Short convert(String source)throws Exception{
			if(source!=null&&source.length()>0){
				return Short.parseShort(source);
			}
			return null;
		}
	}

	public class String2StringConverter implements ParamConverter<String> {
		@Override
		public String convert(String source)throws Exception{
			return source;
		}
	}

	public class String2ByteConverter implements ParamConverter<Byte> {
		@Override
		public Byte convert(String source)throws Exception{
			if(source!=null&&source.length()>0){
				return Byte.parseByte(source);
			}
			return null;
		}
	}

//	public class String2DateConverter implements ParamConverter<Date> {
//		@Override
//		public Date convert(String source)throws Exception{
//			if(source!=null&&source.length()>0){
//				return new Date(DatetimeUtils.parseDatetime(source));
//			}
//			return null;
//		}
//	}
	
}
