package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.service;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.dto.BranchDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.dto.request.BranchRequestDto;
import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.entity.Branch;

import java.util.List;

public interface BranchService {
    public List<BranchDto> getAllBranches();
    public Branch getBranchById(Integer id);
    public BranchDto getDtoById (Integer id);
    public BranchDto getDtoByName (String name);
    public BranchRequestDto getReq(Integer id);
    public void addBranch(BranchRequestDto branchReqDto);
    public boolean updateBranch(Integer id, BranchRequestDto branchReqDto);
    public void deleteBranch(Integer id);
    public boolean existsBranchName(Integer id, String name);
    public Branch toEntity(BranchRequestDto branchReqDto);
    public BranchDto toDto(Branch branch);
}
