package com.guli.edu.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import com.guli.common.vo.R;
import com.guli.edu.entity.Teacher;
import com.guli.edu.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
@CrossOrigin //跨域  protocal hostname port --> cors issue
public class TeacherAdminController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public R list() throws Exception {
        throw new Exception();
//        System.out.println(1/0);
//        List<Teacher> list = teacherService.list(null);
//        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        teacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery) {
        if (page <= 0 || limit <= 0) {
            throw new GuliException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<Teacher> pageParam = new Page<>(page, limit);

        teacherService.pageQuery(pageParam, teacherQuery);

        List<Teacher> records = pageParam.getRecords();

        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }

}

//package com.guli.edu.controller.admin;
//
//
//import com.guli.edu.entity.Teacher;
//import com.guli.edu.service.TeacherService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api(description="讲师管理")
//@RestController
//@RequestMapping("/admin/edu/teacher")
//@CrossOrigin //跨域  protocal hostname port --> cors issue
//public class TeacherAdminController {
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @ApiOperation(value = "所有讲师列表")
//    @GetMapping
//    public List<Teacher> list() {
//        return teacherService.list(null);
//    }
//
//    @ApiOperation(value = "根据ID删除讲师")
//    @DeleteMapping("{id}")
//    public boolean removeById(
//            @ApiParam(name = "id", value = "讲师ID", required = true)
//            @PathVariable String id) {
//        return teacherService.removeById(id);
//    }
//}


//package com.guli.edu.controller.admin;
//
//
//import com.guli.edu.entity.Teacher;
//import com.guli.edu.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin/edu/teacher")
//@CrossOrigin //跨域  protocal hostname port --> cors issue
//public class TeacherAdminController {
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @GetMapping
//    public List<Teacher> list() {
//        return teacherService.list(null);
//    }
//
//    @DeleteMapping("{id}")
//    public boolean removeById(@PathVariable String id) {
//        return teacherService.removeById(id);
//    }
//}

//package com.guli.edu.controller.admin;
//
//
//import com.guli.edu.entity.Teacher;
//import com.guli.edu.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin/edu/teacher")
//public class TeacherAdminController {
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @GetMapping
//    public List<Teacher> list() {
//        return teacherService.list(null);
//    }
//}

//package com.guli.edu.controller.admin;
//
//public class TeacherAdminController {
//}
