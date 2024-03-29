package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.service.impl;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.dto.request.BranchRequestDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.entity.Branch;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.repository.BranchRepository;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepo;

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branches = branchRepo.findAll();
        return branches.stream().map(this::toDto).toList();
    }

    @Override
    public Branch getBranchById(Integer id) {
        return branchRepo.findById(id).orElse(null);
    }

    @Override
    public BranchDto getDtoById(Integer id) {
        Branch branchExisting = branchRepo.findByName(getBranchById(id).getName()).orElse(null);
        if (branchExisting!=null){
            return toDto(branchExisting);
        }
        return null;
    }
    @Override
    public BranchDto getDtoByName(String name) {
        Branch branchExisting = branchRepo.findByName(name).orElse(null);
        if (branchExisting!=null){
            return toDto(branchExisting);
        }
        return null;
    }

    @Override
    public BranchRequestDto getReq(Integer id){
        Branch branch = getBranchById(id);
        return new BranchRequestDto(branch.getName(), branch.getCountry());
    }

    @Override
    public void addBranch(BranchRequestDto branchReqDto) {
        Branch branch = toEntity(branchReqDto);
        toDto(branch).setId(branch.getId());
        branchRepo.save(branch);
    }

    @Override
    public boolean updateBranch(Integer id, BranchRequestDto branchReqDto) {
        Branch existingBranch = getBranchById(id);
        if (existingBranch.getName().equalsIgnoreCase(branchReqDto.getName()) &&
        existingBranch.getCountry().equalsIgnoreCase(branchReqDto.getCountry())){
            return false;
        }
        existingBranch.setName(branchReqDto.getName());
        existingBranch.setCountry(branchReqDto.getCountry());
        branchRepo.save(existingBranch);
        return true;
    }

    @Override
    public void deleteBranch(Integer id) {
        branchRepo.delete(getBranchById(id));
    }

    @Override
    public boolean existsBranchName(Integer id, String name) {
        return getBranchById(id).getName().equalsIgnoreCase(name);
    }

    @Override
    public Branch toEntity(BranchRequestDto reqDto) {
        return new Branch(reqDto.getName(), reqDto.getCountry());
    }

    @Override
    public BranchDto toDto(Branch branch) {
        return new BranchDto(branch.getId(), branch.getName(), branch.getCountry());
    }
}
