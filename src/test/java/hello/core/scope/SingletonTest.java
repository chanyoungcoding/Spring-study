package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

class SingletonTest {

  @Test
  void SingletonBeanFind() {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

    SingletonBean bean1 = ac.getBean(SingletonBean.class);
    SingletonBean bean2 = ac.getBean(SingletonBean.class);

    System.out.println("Bean1 = " + bean1);
    System.out.println("Bean2 = " + bean2);

    Assertions.assertThat(bean1).isEqualTo(bean2);

  }

  @Scope("singleton")
  static class SingletonBean {

    @PostConstruct
    public void init() {
      System.out.println("SingletonBean.init");
    }

    @PreDestroy
    public void close() {
      System.out.println("SingletonBean.destroy");
    }
  }
}
