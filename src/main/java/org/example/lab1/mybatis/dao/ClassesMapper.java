package org.example.lab1.mybatis.dao;

import java.util.List;
import org.example.lab1.mybatis.model.Classes;
import org.mybatis.cdi.Mapper;

@Mapper
public interface ClassesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLASSES
     *
     * @mbg.generated Mon Apr 29 00:19:48 EEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLASSES
     *
     * @mbg.generated Mon Apr 29 00:19:48 EEST 2024
     */
    int insert(Classes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLASSES
     *
     * @mbg.generated Mon Apr 29 00:19:48 EEST 2024
     */
    Classes selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLASSES
     *
     * @mbg.generated Mon Apr 29 00:19:48 EEST 2024
     */
    List<Classes> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CLASSES
     *
     * @mbg.generated Mon Apr 29 00:19:48 EEST 2024
     */
    int updateByPrimaryKey(Classes record);
}