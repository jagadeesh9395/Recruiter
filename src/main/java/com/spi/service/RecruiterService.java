package com.spi.service;

import com.spi.model.Recruiter;
import java.util.List;

public interface RecruiterService<T extends Recruiter> {
    List<Recruiter> getAll();

    T getRecruiter(String id);

    T addRecruiter(T recruiter);

    T updateRecruiter(T recruiter, String id);

    void deleteRecruiter(String id);

    void deleteAllRecruiter();


}
