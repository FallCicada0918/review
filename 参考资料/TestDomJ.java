/*
 * @Description: xml解析 - Dom4J
 * @Author: rendc
 * @Date: 2024-11-22 11:25:04
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-12-11 15:49:08
 */
package com.briup;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class TestDomJ {
  public static void main(String[] args) {
    System.out.println("hello,dom4j!");

    TestDomJ testDomJ = new TestDomJ();
    String filePath = "src/main/java/com/briup/class.xml";
    File file = new File(filePath);
    try {
      // dom4j文档对象
      Document document = testDomJ.parse(file);
      System.out.println("document:" + document);
      // 调用自定方法 处理文档对象
      testDomJ.handle(document);
      // 创建xml文件
      // Document document = testDomJ.createDocument();
      // testDomJ.createXML(document);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 获取dom4j的文档对象
  public Document parse(File file) throws DocumentException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(file);
    return document;
  }

  // main方法中不放太多的业务代码 所以将这些代码提取出来
  public void handle(Document document) {
    System.out.println("handle " + document);
    // 获取节点列表
    // List<Node> list = document.selectNodes("//age");
    // list.forEach(node -> System.out.println(node.getName()+":"+node.getText()));
    // 获取指定节点
    // List<Node> list = document.selectNodes("/students/stu/*");
    // list.forEach(node -> System.out.println(node.getName() + ":" +
    // node.getText()));
    // 获取所有节点
    Element root = document.getRootElement();
    for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
      Element element = it.next();
      System.out.println(element.getName());
    }
    // 获取根节点下指定名称的儿子节点
    for (Iterator<Element> it = root.elementIterator("stu"); it.hasNext();) {
      Element element = it.next();
      System.out.println(element.getName());
    }

    // 获取根节点下属性
    for (Iterator<Attribute> it = root.attributeIterator(); it.hasNext();) {
      Attribute attribute = it.next();
      System.out.println(attribute.getName());
      System.out.println(attribute.getValue());
    }

  }

  // 创建document对象
  public Document createDocument() {
    Document document = DocumentHelper.createDocument();
    Element root = document.addElement("root");
    Element stu = root.addElement("stu")
        .addAttribute("id", "2024001")
        .addAttribute("gender", "0");
    stu.addElement("name").addText("王五");
    stu.addElement("age").addText("23");
    return document;
  }

  // 创建xml文件
  public void createXML(Document document) {
    try {
      FileWriter fileWriter = new FileWriter("src/main/java/com/briup/root.xml");
      document.write(fileWriter);
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}