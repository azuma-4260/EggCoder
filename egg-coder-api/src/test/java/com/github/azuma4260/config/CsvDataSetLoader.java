package com.github.azuma4260.config;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.springframework.core.io.Resource;

public class CsvDataSetLoader extends AbstractDataSetLoader {
  @Override
  protected IDataSet createDataSet(Resource resource) throws Exception {
    return new CsvDataSet(resource.getFile());
  }
}
