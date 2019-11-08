package test_jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity(name = "test_jpa.entity.TestTable")
@Table(name = "test_table")
public class TestTable {

    /**
     * id
     */
    @Id
    @Column(name = "\"id\"", nullable = false)
    private String id;
    /**
     * flag
     */
    @Column(name = "\"flag\"", nullable = false)
    private String flag;
    /**
     * create_time
     */
    @Column(name = "\"create_time\"", nullable = false)
    private Timestamp createTime;
    /**
     * update_time
     */
    @Column(name = "\"update_time\"", nullable = false)
    private Timestamp updateTime;
}