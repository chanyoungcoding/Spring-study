package hello.core.member;

import lombok.Data;

@Data
public class TestMember {
  private Long id;
  private String name;
  private Grade grade;

  public void changeNameAndPrint() {
    this.setName("chan");
    System.out.println(this.name);
  }
}
