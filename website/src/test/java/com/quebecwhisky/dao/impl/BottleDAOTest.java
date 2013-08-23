package com.quebecwhisky.dao.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.quebecwhisky.AbstractSpringDBUnitTest;
import com.quebecwhisky.dao.IBottleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/testCtx.xml")
@Transactional
public class BottleDAOTest extends AbstractSpringDBUnitTest {

	private final Resource mTestRes = new ClassPathResource(
			"com/quebecwhisky/dao/impl/BottleDAOData.xml");

	@Autowired
	private IBottleDAO mDAO;

	@Override
	protected Resource getTestDataResource() {
		return mTestRes;
	}

	@Test
	public void find() {
		assertThat(mDAO.findAll().size(), is(1));
	}

}
