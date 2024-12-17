<!--
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-12-17 09:47:21
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-12-17 10:01:01
 * @Slogan: 無限進步
-->

字段解释

1.`c1.name as categoryName`:

- c1 是 es_category 表的一个别名。
- name 是 es_category 表中的一个字段，表示分类的名称。
- as categoryName 是给这个查询结果的列命名为 categoryName，方便后续引用。

2.`IFNULL(c2.name, '无') as PcategoryName`:

- IFNULL 是一个 SQL 函数，用于判断第一个参数是否为 NULL。
- 如果第一个参数不是 NULL，则返回第一个参数的值；否则返回第二个参数的值。
- c2 是 es_category 表的另一个别名，用于表示父分类。c2.name 表示父分类的名称。
- '无' 是当父分类不存在（即 c2.name 为 NULL）时返回的默认值。
- as PcategoryName 是给这个查询结果的列命名为 PcategoryName，表示父分类的名称。

整体查询逻辑

FROM es_category c1: 从 es_category 表中选择数据，并给这个表起了一个别名 c1。LEFT JOIN es_category c2 ON c1.parent_id = c2.id: 使用左连接（LEFT JOIN）将 es_category 表自身连接到一起，连接条件是当前分类的 parent_id 等于父分类的 id。这样做的目的是为了获取每个分类的父分类信息。
结果示例
假设有以下几条数据在 es_category 表中：



id
name
parent_id




1
电子产品
NULL


2
手机
1


3
电脑
1


4
苹果手机
2



执行上述查询后，结果可能是：



categoryName
PcategoryName




电子产品
无


手机
电子产品


电脑
电子产品


苹果手机
手机



这样，每个分类的名称以及其父分类的名称（如果有）都会显示出来。如果没有父分类，则显示 "无"。
