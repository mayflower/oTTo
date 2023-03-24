/* eslint-disable no-undef */
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./index.html', './src/**/*.{js,ts,jsx,tsx,vue}'],
  theme: {
    extend: {
      transitionProperty: {
        'max-height': 'max-height'
      }
    }
  },
  plugins: []
}
