const Chatting = artifacts.require("Chatting");

module.exports = function (deployer) {
  deployer.deploy(Chatting);
};
