<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="cn.appsys.dao.appinfo.AppInfoMapper">

	<insert id="add" parameterType="AppInfo">
		insert into app_info (softwareName,APKName,supportROM,interfaceLanguage,updateDate,softwareSize,
							devId,appInfo,status,onSaleDate,offSaleDate,categoryLevel1,categoryLevel2,
							categoryLevel3,downloads,flatformId,logoPicPath,logoLocPath,createdBy,creationDate)
				values(#{softwareName},#{APKName},#{supportROM},#{interfaceLanguage},#{updateDate},
					   #{softwareSize},#{devId},#{appInfo},#{status},#{onSaleDate},#{offSaleDate},
					   #{categoryLevel1},#{categoryLevel2},#{categoryLevel3},#{downloads},
					   #{flatformId},#{logoPicPath},#{logoLocPath},#{createdBy},#{creationDate})
	</insert>
	
	<update id="modify" parameterType="AppInfo">
		update app_info
		<trim prefix="set" suffixOverrides="," suffix="where id=#{id}">
			<if test="softwareName != null">softwareName=#{softwareName},</if>
			<!-- <if test="APKName != null">APKName=#{APKName},</if> -->
			<if test="supportROM != null">supportROM=#{supportROM},</if>
			<if test="interfaceLanguage != null">interfaceLanguage=#{interfaceLanguage},</if>
			<if test="updateDate != null">updateDate=#{updateDate},</if>
			<if test="softwareSize != null">softwareSize=#{softwareSize},</if>
			<if test="appInfo != null">appInfo=#{appInfo},</if>
			<if test="status != null">status=#{status},</if>
			<if test="onSaleDate != null">onSaleDate=#{onSaleDate},</if>
			<if test="offSaleDate != null">offSaleDate=#{offSaleDate},</if>
			<if test="categoryLevel1 != null">categoryLevel1=#{categoryLevel1},</if>
			<if test="categoryLevel2 != null">categoryLevel2=#{categoryLevel2},</if>
			<if test="categoryLevel3 != null">categoryLevel3=#{categoryLevel3},</if>
			<if test="downloads != null">downloads=#{downloads},</if>
			<if test="flatformId != null">flatformId=#{flatformId},</if>
			<if test="logoPicPath != null">logoPicPath=#{logoPicPath},</if>
			<if test="logoLocPath != null">logoLocPath=#{logoLocPath},</if>
			<if test="modifyBy != null">modifyBy=#{modifyBy},</if>
			<if test="modifyDate != null">modifyDate=#{modifyDate},</if>
		</trim>
	</update>
	
	<delete id="deleteAppInfoById" parameterType="Integer">
		delete from app_info where id = #{id}
	</delete>
	
	<select id="getAppInfoList" resultType="AppInfo">
		select a.id, a.softwareName,a.APKName,a.supportROM,a.softwareSize,a.devId,
				(select devName from dev_user where id = a.devId) as devName,
				a.status,
				(select valueName from data_dictionary d where  a.status=d.valueId AND d.typeCode='APP_STATUS') as statusName,
				a.flatformId,
				(select valueName from data_dictionary d where  a.flatformId=d.valueId AND d.typeCode='APP_FLATFORM') as flatformName,
				a.categoryLevel1,
				(select categoryName from app_category c where  c.id=a.categoryLevel1) as categoryLevel1Name,
				a.categoryLevel2,
				(select categoryName from app_category c where  c.id=a.categoryLevel2) as categoryLevel2Name,
				a.categoryLevel3,
				(select categoryName from app_category c where  c.id=a.categoryLevel3) as categoryLevel3Name,
				a.downloads,
				a.onSaleDate,
				a.versionId,
				(select v.versionNo from app_version v where v.id=a.versionId ) as versionNo
			from  app_info a
		<trim prefix="where" prefixOverrides="and | or">
			<if test="softwareName != null and softwareName != ''">
				and a.softwareName like CONCAT ('%',#{softwareName},'%')
			</if>
			<if test="status != null">
				and a.status = #{status}
			</if>
			<if test="categoryLevel1 != null">
				and a.categoryLevel1 = #{categoryLevel1}
			</if>
			<if test="categoryLevel2 != null">
				and a.categoryLevel2 = #{categoryLevel2}
			</if>
			<if test="categoryLevel3 != null">
				and a.categoryLevel3 = #{categoryLevel3}
			</if>
			<if test="flatformId != null">
				and a.flatformId = #{flatformId}
			</if>
			<if test="devId != null">
				and a.devId = #{devId}
			</if>
		</trim>
		order by creationDate DESC limit #{from},#{pageSize}
	</select>
	
	<select id="getAppInfoCount" resultType="Int">
		select count(*) as count from app_info a
			<trim prefix="where" prefixOverrides="and | or">
				<if test="softwareName != null and softwareName != ''">
					and a.softwareName like CONCAT ('%',#{softwareName},'%')
				</if>
				<if test="status != null">
					and a.status = #{status}
				</if>
				<if test="categoryLevel1 != null">
					and a.categoryLevel1 = #{categoryLevel1}
				</if>
				<if test="categoryLevel2 != null">
					and a.categoryLevel2 = #{categoryLevel2}
				</if>
				<if test="categoryLevel3 != null">
					and a.categoryLevel3 = #{categoryLevel3}
				</if>
				<if test="flatformId != null">
					and a.flatformId = #{flatformId}
				</if>
				<if test="devId != null">
					and a.devId = #{devId}
				</if>
			</trim>
	</select>
	
	<select id="getAppInfo" resultType="AppInfo">
		select * ,
			(select devName from dev_user where id = a.devId) as devName,
			(select valueName from data_dictionary d where  a.status=d.valueId AND d.typeCode='APP_STATUS') as statusName,
			(select valueName from data_dictionary d where  a.status=d.valueId AND d.typeCode='APP_FLATFORM') as flatformName,
			(select categoryName from app_category c where  c.id=a.categoryLevel1) as categoryLevel1Name,
			(select categoryName from app_category c where  c.id=a.categoryLevel2) as categoryLevel2Name,
			(select categoryName from app_category c where  c.id=a.categoryLevel3) as categoryLevel3Name,
			(select v.versionNo from app_version v where v.id=a.versionId ) as versionNo
		  from app_info a
		  <trim prefix="where" prefixOverrides="and | or">
				<if test="id != null">
					and a.id = #{id}
				</if>
				<if test="APKName != null">
					and a.APKName = #{APKName}
				</if>
		  </trim>
	</select>
	<update id="deleteAppLogo" parameterType="Integer">
		update app_info 
			set logoPicPath=null,
				logoLocPath = null 
			where id = #{id}
	</update>
	<update id="updateVersionId">
		update app_info 
			set versionId=#{versionId}
			where id = #{id}
	</update>

	<update id="updateSatus">
		update app_info 
			set status=#{status}
			where id = #{id}
	</update>
</mapper>