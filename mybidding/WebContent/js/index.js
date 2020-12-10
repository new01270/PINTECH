App = {
	web3Provider: null,
	contract: {},
	bidList: ['경매물품1', '경매물품2'],

	// 화면구현
	init: async function() {

		const table = document.getElementById('table1');
		for (let i = 0; i < App.bidList.length; i++) {
			const row = table.insertRow();	//()안 값이 없으면 마지막행에 추가.
			const cell1 = row.insertCell(0);
			const cell2 = row.insertCell(1);
			const cell3 = row.insertCell(2);

			cell1.innerHTML = App.bidList[i];
			cell2.innerHTML = "name";
			cell3.innerHTML = "0";

			$('#title').append($('<option>').html(App.bidList[i]));
		}
		return await App.initWeb3();
	},

	// 메타마스크 Provider 연결
	initWeb3: async function() {
		if (window.ethereum) {
			App.web3Provider = window.ethereum;
			try {
				await window.ethereum.enable();
			} catch (error) {
				console.error("Used denied account access");
			}
		} else if (window.web3) {
			App.web3Provider = window.web3.currentProvider;
		} else {
			App.web3Provider = new Web3.providers.HttpProvider("http://127.0.0.1:7545");
		}
		web3 = new Web3(App.web3Provider);
		return App.initContract();
	},

	// 컨트랙트 연결
	initContract: function() {

		App.contract = new web3.eth.Contract(abi);
		App.contract.options.address = "0xF4e9AD5fc43B513D3195F0A8b68e0dBB6E28c994";

		App.bindEvents();
		App.highbid();
		App.recentbid();
	},

	// 입찰버튼
	bindEvents: function() {
		$('#savebutton').on('click', App.setBid);
	},

	highbid: function() {
		App.contract.events.highestVoter({}, function(err, res) {

			var title = decodeURI(res.returnValues.htitle);
			console.log(res);
			if (err) {
				console.log(i);
				return;
			}
			if (title == "경매물품1") {
				i = 1;
			} else if (title == "경매물품2") {
				i = 2;
			}

			const table = document.getElementById('table1');
			const row = table.rows[i];
			const cell2 = row.cells[1];
			const cell3 = row.cells[2];

			cell2.innerHTML = res.returnValues.hName;
			cell3.innerHTML = web3.utils.fromWei(res.returnValues.hAmount);

		})
	},	//event  겟참조 highestVoter이벤트구독
	recentbid: function() {
		App.contract.events.recentVoter({}, function(err, res) {
			var rtitle = decodeURI(res.returnValues.rtitle);
			var rName = res.returnValues.rName;
			var rAmount = res.returnValues.rAmount;

			$('#rTitle').text(rtitle);
			$('#rFname').html(rName);
			$('#rAmount').text(web3.utils.fromWei(rAmount));
		})


	},	//event	겟첨조 recentVoter 이벤트구독

	//버튼 이벤트 핸들러	셋참조 contract bid1함수 호풓
	setBid: function() {
		event.preventDefault();

		var title = encodeURI($('#title').val());
		var name = $('#name').val();
		var bid = web3.utils.toWei($('#bid').val());

		web3.eth.getAccounts(function(error, accounts) {

			if (error) {
				console.log(error);
				return;
			}

			var account = accounts[0];

			console.log(web3.utils.toWei(bid, 'ether'));

			if ($('#title').val() == "경매물품1") {
				App.contract.methods.bid1(title, name)
					.send({ from: account, value: bid })	//단위환산
					.then(function(result) { console.log(result) });
			} else if ($('#title').val() == "경매물품2") {
				return App.contract.methods.bid2(title, name)
					.send({ from: account, value: bid })	//단위환산
					.then(function(result) { console.log(result) });
			}
		})
	}
}

$(function() {
	App.init();
})

