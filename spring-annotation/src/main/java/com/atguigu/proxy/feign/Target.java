package com.atguigu.proxy.feign;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/29 18:43
 **/
public interface Target<T> {

    Class<T> type();

    /* configuration key associated with this target. For example, {@code route53}. */
    String name();

    /* base HTTP URL of the target. For example, {@code https://api/v2}. */
    String url();

    public static class HardCodedTarget<T> implements Target<T> {

        private final Class<T> type;
        private final String name;
        private final String url;

        public HardCodedTarget(Class<T> type, String name, String url) {
            this.type = type;
            this.name = name;
            this.url = url;
        }

        @Override
        public Class<T> type() {
            return null;
        }

        @Override
        public String name() {
            return null;
        }

        @Override
        public String url() {
            return null;
        }

        public String apply(String requestTemplate) {
            System.out.println();
            return requestTemplate;
        }
    }

}