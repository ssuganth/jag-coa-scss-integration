require('dotenv').config()

module.exports = (on, config) => {
  // copy any needed variables from process.env to config.env
  config.env.wm_host = process.env.WEB_METHODS_HOST

  // do not forget to return the changed config object!
  return config
}
