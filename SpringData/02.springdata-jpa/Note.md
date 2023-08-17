## 使用SpringDataRepository

#### SpringDataRepository抽象的目标是显著减少为各种持久性存储实现数据访问层所需的样板代码量

CrudRepository
```java
// 用来插入和修改 有主键就是修改 没有就是新增
// 获得插入后自增id，获得返回值
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S entity);

    //通过集合保存多个实体
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    //通过主键查询实体
    Optional<T> findById(ID id);

    //通过主键查询是否存在 返回boolean
    boolean existsById(ID id);

    //查询所有
    Iterable<T> findAll();

    //通过集合的主键 查询多个实体，返回集合
    Iterable<T> findAllById(Iterable<ID> ids);
    
    //查询总量
    long count();

    //根据id进行删除
    void deleteById(ID id);

    //根据实体进行删除
    void delete(T entity);

    //删除多个（传集合ID）
    void deleteAllById(Iterable<? extends ID> ids);

    //删除多个（传集合实体）
    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();
}
```

### 自定义操作
1.jpql(原生SQL)

    @Query
    设置参数方式：1.索引 ?数字 ; 2.具名 :参数名 结合@Param注解指定
    增删改: 1.要加上事务的支持 
            @Transactional //通常会放在业务逻辑层
            @Modifying //通知SpringDataJpa 是增删改操作
           2.如果是插入方法：一定只能在hibernate下才支持(Insert into ..select)

2.规定方法名
    
    支持的查询方法主题关键字（前缀）
        决定当前方法的作用
        只支持查询和删除


3.Query by Example
    
    a.只支持查询
        i.不支持嵌套或分组的属性约束，如firstname = ? or (firstname = ? 1 and lastname = ? 2)
        ii.只支持字符串 start/contains/ends/regex匹配和其他属性类型的精确匹配

4.通过Specifications

5.通过Querydsl