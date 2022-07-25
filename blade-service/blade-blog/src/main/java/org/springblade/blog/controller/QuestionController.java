/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.blog.utils.HTMLSpirit;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.blog.entity.Question;
import org.springblade.blog.vo.QuestionVO;
import org.springblade.blog.service.IQuestionService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 *  控制器
 *
 * @author Blade
 * @since 2022-07-25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/question")
@Api(value = "", tags = "接口")
public class QuestionController extends BladeController {

	private IQuestionService questionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入question")
	public R<Question> detail(Question question) {
		Question detail = questionService.getOne(Condition.getQueryWrapper(question));
		return R.data(detail);
	}

	/**
	 * 分页
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入question")
	public R<IPage<Question>> list(Question question, Query query) {
		IPage<Question> pages = questionService.page(Condition.getPage(query), Condition.getQueryWrapper(question));
		List<Question> records = pages.getRecords();
		records.forEach(b->{
			b.setDescription(HTMLSpirit.delHTMLTag(b.getDescription()));
		});
		return R.data(pages);
	}

	/**
	 * 自定义分页
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入question")
	public R<IPage<QuestionVO>> page(QuestionVO question, Query query) {
		IPage<QuestionVO> pages = questionService.selectQuestionPage(Condition.getPage(query), question);
		return R.data(pages);
	}

	/**
	 * 新增
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入question")
	public R save(@Valid @RequestBody Question question) {
		return R.status(questionService.save(question));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入question")
	public R update(@Valid @RequestBody Question question) {
		return R.status(questionService.updateById(question));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入question")
	public R submit(@Valid @RequestBody Question question) {
		return R.status(questionService.saveOrUpdate(question));
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(questionService.deleteLogic(Func.toLongList(ids)));
	}


}
