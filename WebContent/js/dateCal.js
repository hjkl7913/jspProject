function timeForToday(value) {
        const today = new Date();
        console.log(today);
        const timeValue = new Date(value);

        const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
        if (betweenTime < 1) return '방금전';
        if (betweenTime < 60) {
        	console.log(betweenTime+"분전");
            var result1 = `${betweenTime}분전`;
            return result1;
        }

        const betweenTimeHour = Math.floor(betweenTime / 60);
        if (betweenTimeHour < 24) {
        	console.log(betweenTimeHour+"시간전");
        	var result2 = `${betweenTimeHour}시간전`;
        	return result2;
        }

        const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
        if (betweenTimeDay < 365) {
        	console.log(betweenTimeDay+"일전");
        	var result3 = `${betweenTimeDay}일전`;
        	return result3;
        }
        var result4 = `${Math.floor(betweenTimeDay / 365)}년전`;
        return result4;
 }