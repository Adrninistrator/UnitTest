package adrninistrator.test_jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

@Data
@Entity(name = "adrninistrator.test_jpa.entity.TestTable2")
@Table(name = "test_table2",
        indexes = {
                @Index(name = "uni_test_table2", columnList = "char1,char2", unique = true),
                @Index(name = "idx_test_table2_1", columnList = "datetime1")
        })
public class TestTable2 {

    /**
     * 测试-id
     */
    @Id
    @Column(name = "\"id\"", length = 20, nullable = false)
    private String id;
    /**
     * 测试-char1
     */
    @Column(name = "\"char1\"", length = 1, nullable = false)
    private String char1;
    /**
     * 测试-char2
     */
    @Column(name = "\"char2\"", length = 30, nullable = false)
    private String char2;
    /**
     * 测试-blob1
     */
    @Column(name = "\"blob1\"", length = 65535)
    private Blob blob1;
    /**
     * 测试-blob2
     */
    @Column(name = "\"blob2\"", length = 255)
    private byte[] blob2;
    /**
     * 测试-text1
     */
    @Column(name = "\"text1\"", length = 65535)
    private Clob text1;
    /**
     * 测试-text2
     */
    @Column(name = "\"text2\"", length = 255)
    private String text2;
    /**
     * 测试-int_1
     */
    @Column(name = "\"int_1\"", length = 10)
    private Integer int1;
    /**
     * 测试-int_2
     */
    @Column(name = "\"int_2\"", length = 10)
    private Integer int2;
    /**
     * 测试-decimal1
     */
    @Column(name = "\"decimal1\"", length = 10, precision = 10)
    private java.math.BigDecimal decimal1;
    /**
     * 测试-decimal2
     */
    @Column(name = "\"decimal2\"", length = 18, precision = 18, scale = 2)
    private java.math.BigDecimal decimal2;
    /**
     * 测试-datetime1
     */
    @Column(name = "\"datetime1\"", length = 19)
    private Timestamp datetime1;
    /**
     * 测试-datetime2
     */
    @Column(name = "\"datetime2\"", length = 19)
    private Timestamp datetime2;
    /**
     * 测试-timestamp1
     */
    @Column(name = "\"timestamp1\"", length = 19, nullable = false)
    private Timestamp timestamp1;
    /**
     * 测试-timestamp2
     */
    @Column(name = "\"timestamp2\"", length = 19, nullable = false)
    private Timestamp timestamp2;
}