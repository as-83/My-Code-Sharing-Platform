package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.repos.CodeRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CodeService {
    private CodeRepo codeRepo;

    public CodeService(@Autowired CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    public List<Code> getAllCodes() {
        return (List<Code>) codeRepo.findAll();
    }

    public Optional<Code> getCodeById(long number) {
            return codeRepo.findById(number);
    }

    public Code addCode(Code newCode) {
        return codeRepo.save(newCode);
    }

    public List<Code> getLatestTenCodes() {
        return ((List<Code>) codeRepo.findAll()).stream()
                .sorted(Comparator.comparing(Code::getId).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
