package com.br.mvsistemas.erp.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.soulwing.rot13.Rot13;
import org.soulwing.rot13.Rot13Reader;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		try {
			//craindo o caminho e o arquivo
			PROPRIEDADES.getParentFile().mkdir();
			PROPRIEDADES.createNewFile();
			
			String senha = com.Ostermiller.util.Base64.encode("lu19112009");
			
			if (PROPRIEDADES.length() == 0) {
				//escrevendo dados no arquivo
				BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PROPRIEDADES.getPath()));
				buffWrite.append("javax.persistence.jdbc.url = jdbc:mysql://localhost/mvsistemas\n");
				buffWrite.append("javax.persistence.jdbc.user = root\n");
				buffWrite.append("javax.persistence.jdbc.password = "+senha+"\n");
				buffWrite.append("javax.persistence.jdbc.driver = com.mysql.jdbc.Driver\n");
				buffWrite.append("javax.persistence.schema-generation.create-source = metadata\n");
				buffWrite.append("hibernate.hbm2ddl.auto = update\n");
				buffWrite.append("hibernate.show_sql = false\n");
				buffWrite.append("hibernate.format_sql = false");
				buffWrite.close();
				
			}
			
			Properties prop = getProp();
			Map<String, String> propiedade = new HashMap<String, String>();
			
			//Mapeando os dados do arquivo de propriedade
			propiedade.put("javax.persistence.jdbc.url", prop.getProperty("javax.persistence.jdbc.url"));
			propiedade.put("javax.persistence.jdbc.user", prop.getProperty("javax.persistence.jdbc.user"));
			propiedade.put("javax.persistence.jdbc.password", com.Ostermiller.util.Base64.decode(prop.getProperty("javax.persistence.jdbc.password")));				
			propiedade.put("javax.persistence.jdbc.driver", prop.getProperty("javax.persistence.jdbc.driver"));
			propiedade.put("javax.persistence.schema-generation.create-source", prop.getProperty("javax.persistence.schema-generation.create-source"));
			
			propiedade.put("hibernate.hbm2ddl.auto", prop.getProperty("hibernate.hbm2ddl.auto"));
			propiedade.put("hibernate.show_sql", prop.getProperty("hibernate.show_sql"));
			propiedade.put("hibernate.format_sql", prop.getProperty("hibernate.format_sql"));
			
			this.factory = Persistence.createEntityManagerFactory("MvSistemasPU",propiedade);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
	
	
	@SuppressWarnings("unused")
	private static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(PROPRIEDADES.getPath());
		props.load(file);
		return props;

	}
	
	private static final java.io.File PROPRIEDADES = new java.io.File(
            System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "properties"
            + System.getProperty("file.separator")
            + "dados.properties");
	
}