int reverse(int x) {
  int flag = 0;

  if (x < 0) {
    flag = 1;
    if(x== (1<<31))
      return 0;
    x = 0 - x;

  }

  int result  = 0;
  int mask = 0xF;   //掩码
  int origin = x;
  while (original != 0) {
    result <<= 4;
    result |= original & mask;
    original >>= 4;
  }
  if (flag)
    return 0 - result;
  return result;
}
