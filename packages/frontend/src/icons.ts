import { library } from '@fortawesome/fontawesome-svg-core'
import { faUser, faClock, faLocationDot, faChevronDown } from '@fortawesome/free-solid-svg-icons'

export function initializeIcons() {
  library.add(faUser, faClock, faLocationDot, faChevronDown)
}
