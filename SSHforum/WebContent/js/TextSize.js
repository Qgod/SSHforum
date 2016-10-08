function testAuto(thisId, needLeng) {
	var MainText = document.getElementById(thisId);
	var nowLeng = MainText.innerHTML.length;
	if (nowLeng > needLeng) {
		var nowWord = MainText.innerHTML.substr(0, needLeng) + '...';
		MainText.innerHTML = nowWord;
	}
}

