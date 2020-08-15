package adrninistrator.test_jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "adrninistrator.test_jpa.entity.TestTable")
@Table(name = "test_table",
        indexes = {
                @Index(name = "idx_test_table_1", columnList = "flag")
        })
public class TestTable {

    /**
     * id
     */
    @Id
    @Column(name = "\"id\"", length = 32, nullable = false)
    private String id;
    /**
     * flag
     */
    @Column(name = "\"flag\"", length = 32, nullable = false)
    private String flag;
    /**
     * create_time
     */
    @Column(name = "\"create_time\"", length = 19, nullable = false)
    private Timestamp createTime;
    /**
     * update_time
     */
    @Column(name = "\"update_time\"", length = 19, nullable = false)
    private Timestamp updateTime;
}