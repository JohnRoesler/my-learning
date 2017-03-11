text = "X-DSPAM-Confidence:    0.8475"
fltpos = text.find(":")
flt = text[fltpos+2:]
flt = float(flt)
print flt