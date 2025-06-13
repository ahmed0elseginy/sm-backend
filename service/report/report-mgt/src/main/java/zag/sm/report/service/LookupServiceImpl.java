package zag.sm.report.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.sm.report.mapper.ReportMapper;
import zag.sm.report.model.generated.LookupResultSet;
import zag.sm.report.model.generated.LookupVTO;
import zag.sm.report.repository.jpa.CategoryJPARepository;
import zag.sm.report.repository.jpa.StatusJPARepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LookupServiceImpl implements LookupSerivce {

    private final StatusJPARepository statusRepository;
    private final CategoryJPARepository categoryRepository;
    private final ReportMapper reportMapper;

    @Override
    public LookupResultSet getCategories() {
        List<LookupVTO> categories = categoryRepository.findAll()
                .stream()
                .map(reportMapper::toLookupVTO)
                .toList();
        return LookupResultSet.builder().data(categories).build();
    }

    @Override
    public LookupResultSet getStatues() {
        List<LookupVTO> statuses = statusRepository.findAll().stream()
                .map(reportMapper::toLookupVTO)
                .toList();
        return LookupResultSet.builder().data(statuses).build();
    }

}
