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
 * 删除用户
 * @param form
 */
function deleteUser(form) {
	var uids;
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
					uids = cbxoption[i].id;
				else
					uids += "," + cbxoption[i].id;
			}
		}

		form.userids.value = uids;
	}
	if (m == 0) {
		alert("你没有选中需要删除的用户，请重选！");
		return;
	}
	else
	{
		if(!confirm("是否将选中的用户信息删除?")){
	   	  	return; 
	   }
	}
	location.href = "deleteUser.do?uids=" + uids;
}




/**
 * 新增用户
 */
function addUser() {
	location.href = "addUser.do";
}



/**
 * 修改用户信息
 * @param form
 */
function editUser(form) {
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
					alert("一次只能修改一个用户的信息，请重选！");
					return;
				}
				did = cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要修改的用户，请重选！");
		return;
	}
	console.log(did)
	location.href = "editUser.do?uid=" + did;
}