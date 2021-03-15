package com.solr.api.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;
import com.solr.api.model.Student;

public interface StudentRepository extends SolrCrudRepository<Student, Integer>{

	Student findByName(String name);

}
