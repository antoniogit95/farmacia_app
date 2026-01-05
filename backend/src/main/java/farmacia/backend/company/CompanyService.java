package farmacia.backend.company;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {
    
    private final BranchRepository branchRepository;
    private final CompanyRepository companyRepository;

    public Branch getBranch(){
        Optional<Branch> branchOptional = branchRepository.findById((long) 1);
        return branchOptional.get();
    }

    public Company getCompany(){
        Optional<Company> companyOptional = companyRepository.findById((long) 1);
        return companyOptional.get();
    }

}
