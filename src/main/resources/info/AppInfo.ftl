

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ${table.className} implements Serializable {
	<#list table.columns as column>
		//${column.remarks}
		private ${column.javaType} ${column.fileName};
	</#list>

	<#list table.columns as column>

		public void set${column.upperFileName}(${column.javaType} ${column.fileName} ) {
				this.${column.fileName} = ${column.fileName};
		}

		public ${column.javaType} get${column.upperFileName}() {
				return ${column.fileName};
		}
	</#list>

		

}
