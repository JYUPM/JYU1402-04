/**
 * 全选
 * @param form
 */
function checkall(form) {
	var cbxoption;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if(!cbxoption[i].disabled) {
				cbxoption[i].checked = true;
			}
		}
	}
}
/**
 * 全不选
 * @param form
 */
function uncheckall(form) {
	var cbxoption;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			cbxoption[i].checked = false;
		}
	}
}

/**
 * 删除课程
 * @param form
 */
function deleteCourse(form) {
	var cids;
	var cbxoption;
	var m = 0;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					cids = cbxoption[i].id;
				else
					cids += "," + cbxoption[i].id;
			}
		}

		form.courseids.value = cids;
	}
	if (m == 0) {
		alert("你没有选中需要删除的课程，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否将选中的课程信息删除?")){
	   	  	return; 
	   }
	}
	location.href = "deleteCourse.do?cids=" + cids;
}

function  deleteElectiveCourse(form) {
	var eids;
	var cbxoption;
	var m = 0;
	cbxoption = form.elements;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					eids = cbxoption[i].id;
				else
					eids += "," + cbxoption[i].id;
			}
		}

		form.electiveids.value = eids;
	}
	if (m == 0) {
		alert("你没有选中需要退选的课程，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否将选中的课程退选?")){
	   	  	return; 
	   }
	}
	location.href = " deleteElective.do?eids=" + eids;
}


/**
 * 新增课程
 */
function addCourse() {
	location.href = "addCourse.do";
}


function addElectiveCourse() {
	location.href = "addElective.do";
}

/**
 * 确定选课
 * @param form
 */
function defineElectiveCourse(form) {
	var cbxoption, decids;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m == 1)
					decids = cbxoption[i].id;
				else
					decids += "," + cbxoption[i].id;
			}
		}
	}
	form.courseids.value = decids;
	if (m == 0) {
		alert("你没有选中需要选修的课程，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否选修选中的课程?")){
	   	  	return; 
	   }
	}
	location.href = "defineElective.do?decids=" + decids;
}


/**
 * 修改课程信息
 * @param form
 */
function editCourse(form) {
	var cbxoption, did, username;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m > 1) {
					alert("一次只能修改一个课程的信息，请重选！");
					return;
				}
				did = cbxoption[i].id;
			}
		}
	}
	
	if (m == 0) {
		alert("你没有选中需要修改的课程，请重选！");
		return;
	}
	
	location.href = "editCourse.do?cid=" + did;
}