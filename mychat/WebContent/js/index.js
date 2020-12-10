App = {
	web3Provider: null,
	contract: null,

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

	initContract: function() {
		App.contract = new web3.eth.Contract(abi);
		App.contract.options.address = "0x4Bf9236CeFE630951064E59AbcE1440aEDe6522d";

		App.bindEvents();
		App.getChat();
	},

	bindEvents: function() {
		$('#button').on('click', App.setChat);

	},

	setChat: function() {

		event.preventDefault();

		var name = encodeURI($('#name').val());
		var msg = encodeURI($('#chatting').val());

		web3.eth.getAccounts(function(error, accounts) {
			if (error) {
				console.log(error);
				return;
			}
			var account = accounts[0];

			return App.contract.methods.setChat(name, msg)
				.send({ from: account })
				.then(function(result) { console.log(result) });
		})
	},

	getChat: function() {
		App.contract.events.chat({}, function(err, res) {
			console.log(res);
			if (!err) {
				let name = decodeURI(res.returnValues.name);
				let message = decodeURI(res.returnValues.message);

				const div = document.createElement('div');
				div.className = 'card';
				const date = new Date(parseInt(res.returnValues.timeStamp) * 1000);
				const string =
					`<h5 class="card-header">${name}</h5>
					<div class="card-body">
						<h5 class="card-title">${message}</h5>
						<p class="card-text">${date}</p>
					</div>
					`;
				div.innerHTML = string;
				$('#msg').append(div);
			}
			else console.log(err);
		})
	}
}

$(function() {
	App.initWeb3();
})